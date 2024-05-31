"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';
import './MainPage.css';

interface BoardTitle {
  title: string;
  endpoint: string;
}

const boardTitles: BoardTitle[] = [
  { title: "유튜브 숏폼 Top10", endpoint: "/youtube-shorts/latest" },
  { title: "유튜브 롱폼 Top10", endpoint: "/youtube-long/latest" },
  { title: "네이버 뉴스(정치)", endpoint: "/naver-politics/latest" },
  { title: "네이버 뉴스 (경제)", endpoint: "/naver-economy/latest" },
  { title: "네이버 뉴스(스포츠)", endpoint: "/naver-sports/latest" },
  { title: "네이버 뉴스(게임)", endpoint: "/naver-game/latest" }
];

interface Post {
  pid: string; // 고유한 Post ID를 나타내는 속성 추가
  title: string;
  // 필요한 다른 속성들을 여기에 추가하세요
}

interface Posts {
  [key: string]: Post[];
}

function MainPage() {
  const [posts, setPosts] = useState<Posts>({});

  const fetchPosts = async () => {
    const newPosts: Posts = {};
    for (let board of boardTitles) {
      const response = await axios.get<Post[]>(`http://localhost:8080/api/posts${board.endpoint}`);
      newPosts[board.title] = response.data;
    }
    setPosts(newPosts);
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className="main-content">
          {boardTitles.map((board, index) => (
            <div key={index} className="board-row">
              <div className="board">
                <div className="board-title">{board.title}</div>
                <div className="sub-board">
                  <div className="sub-board-content">
                    {posts[board.title]?.map((post) => (
                      <div key={post.pid}>{post.title}<br/></div> // key를 post.pid로 변경
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
