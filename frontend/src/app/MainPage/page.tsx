"use client";
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useRouter } from 'next/navigation'; // next/navigation에서 useRouter를 import 합니다.
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';
import './MainPage.css';

interface BoardTitle {
  title: string;
  endpoint: string;
  category: string;
}

const boardTitles: BoardTitle[] = [
  { title: "유튜브 숏폼 Top10", endpoint: "/youtube-shorts/latest", category: "youtube-shorts"  },
  { title: "유튜브 롱폼 Top10", endpoint: "/youtube-long/latest", category: "youtube-long"  },
  { title: "네이버 뉴스(정치)", endpoint: "/naver-politics/latest", category: "naver-politics"  },
  { title: "네이버 뉴스 (경제)", endpoint: "/naver-economy/latest" , category: "naver-economy" },
  { title: "네이버 뉴스(스포츠)", endpoint: "/naver-sports/latest", category: "naver-sports"  },
  { title: "네이버 뉴스(게임)", endpoint: "/naver-game/latest", category: "naver-game" }
];

interface Post {
  pid: string;
  title: string;
}

interface Posts {
  [key: string]: Post[];
}

function MainPage() {
  const [posts, setPosts] = useState<Posts>({});
  const router = useRouter(); // next/navigation의 useRouter 훅을 사용합니다.

  const fetchPosts = async () => {
    const newPosts: Posts = {};
    for (let board of boardTitles) {
      const response = await axios.get(`http://localhost:8080/api/posts${board.endpoint}`);
      newPosts[board.title] = Array.isArray(response.data.content) ? response.data.content : [];
    }
    setPosts(newPosts);
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  // 클릭 이벤트 핸들러 함수
  const handleBoardClick = (category: string) => {
    router.push(`/ListPage/${category}`); // 클릭 시 해당 category로 라우팅합니다.
  };
    // 클릭 이벤트 핸들러 함수
    const handleTitleClick = (pid: String) => {
      router.push(`/DetailPage/${pid}`); // 클릭 시 해당 category로 라우팅합니다.
    };

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className="main-content">
          {boardTitles.map((board, index) => (
            <div key={index} className="board-row" > {/* 각 보드에 클릭 이벤트 핸들러를 추가합니다. */}
              <div className="board">
                <div className="board-title"><a  onClick={() => handleBoardClick(board.category)}>{board.title}</a></div>
                <div className="sub-board">
                  <div className="sub-board-content">
                    {posts[board.title]?.map((post) => (
                      <div key={post.pid}><a onClick={() => handleTitleClick(post.pid)}>{post.title}</a><br/></div>
                    ))}
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
        <RightSidebar />
      </div>
      <Footer />
    </div>
  );
}

export default MainPage;
