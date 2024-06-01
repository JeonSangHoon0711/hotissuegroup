"use client"
// app/DetailPage/[pid]/page.tsx

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../../Header/page";
import LeftSidebar from '../../LeftSidebar/page';
import RightSidebar from '../../RightSidebar/page';
import Footer from '../../Footer/page';
import '../detailpage.css';
import { useParams } from 'next/navigation'; // next/router에서 변경됐을 수 있습니다.

type Post = {
  pid: number;
  title: string;
  content: string;
  category: string;
  views: number;
  likecount: number;
  link: string;
  date: string;
};

type Comment = {
  id: number;
  user: string;
  date: string;
  content: string;
};

const mockComments: Comment[] = [
  {
    id: 1,
    user: "사용자1",
    date: "2024-05-08",
    content: "이것은 첫 번째 댓글입니다. 내용이 좀 더 길어질 수 있습니다.",
  },
  {
    id: 2,
    user: "사용자2",
    date: "2024-05-09",
    content: "두 번째 댓글. 동해물과 백두산이 마르고 닳도록.",
  },
  // 필요한 만큼 댓글 추가
];

const DetailPage: React.FC = () => {
  const [post, setPost] = useState<Post | null>(null);
  const [comments, setComments] = useState<Comment[]>(mockComments);
  const { pid } = useParams(); // URL의 pid 매개변수 값을 가져옴

  // 유튜브 링크를 임베드 링크로 변환하는 함수
  const convertToEmbedLink = (link: string): string => {
    const videoIDMatch = link.match(/(?:https?:\/\/)?(?:www\.)?youtube\.com\/watch\?v=([^&]+)/);
    return videoIDMatch ? `https://www.youtube.com/embed/${videoIDMatch[1]}` : link;
  };

  // 포스트 데이터를 가져오는 함수
  useEffect(() => {
    // fetchPost 함수를 useEffect 내부에 직접 정의
    const fetchPost = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/posts/${pid}`);
        setPost(response.data);
      } catch (error) {
        console.error('포스트를 가져오는 중 오류가 발생했습니다.', error);
      }
    };

    fetchPost();
  }, [pid]); // pid가 변경될 때마다 useEffect 실행


  if (!post) {
    return <div>Loading...</div>; // 데이터를 불러오는 동안 로딩 표시
  }

  const embedLink = convertToEmbedLink(post.link);
  const sitelink = post.link;

  // YouTube 플레이어를 조건적으로 렌더링하는 함수
const renderMediaContent = (post: { category: string | string[]; link: string; }) => {
  // 포스트의 카테고리가 YouTube 관련이라면 YouTube 플레이어를 렌더링
  if (post.category.includes('youtube')) {
    const embedLink = convertToEmbedLink(post.link);
    return (
      <div className='youtubePlayer'>
        <iframe
          width="560"
          height="315"
          src={embedLink}
          title="YouTube video player"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowFullScreen>
        </iframe>
      </div>
    );
  } 
};
const renderPostInfo = (post: Post) => {
  // 'youtube'를 포함하는 카테고리일 때
  if (post.category.includes('youtube')) {
    return (
      <div>
        <p>date : {post.date}</p>
        <p>tag : {post.content}</p>
        <p>조회수: {post.views}회</p>
        <p>좋아요: {post.likecount}개</p>
        <p>Category: {post.category}</p>
      </div>
    );
  } 
  // 'youtube'를 포함하지 않는 다른 카테고리일 때
  else {
    return (
      <div>
        <p>date : {post.date}</p>
        <p>{post.content}</p>
        <p>Category: {post.category}</p>
      </div>
    );
  }
};

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className='detailpagecontent'>
          <div className='posttitle'>{post.title}</div>
          <div className='detailpagepost'>
            <div className='detailpost'>
              <div className='youtubePlayer'>
              {renderMediaContent(post)}
              </div>
              {renderPostInfo(post)}
              
              <a href={sitelink} target="_blank" rel="noopener noreferrer">{post.link}</a>
            </div>
          </div>
          <div className='comment'>
            <h2>Comments</h2>
            <div className='commentcontent'>
              {comments.map((comment) => (
                <p key={comment.id}><strong>{comment.user}</strong> ({comment.date}): {comment.content}</p>
              ))}
            </div>
          </div>
        </div>
        <RightSidebar />
      </div>
      <Footer />
    </div>
  );
};

export default DetailPage;
