"use client"
// ListPage/[category]/page.tsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useRouter } from 'next/navigation';
import Header from '@/app/Header/page';
import LeftSidebar from '@/app/LeftSidebar/page';
import RightSidebar from '@/app/RightSidebar/page';
import Footer from '@/app/Footer/page';
import '../ListPage.css';

type Post = {
  pid: number;
  title: string;
  content: string;
  category_name: string;
};

const truncateContent = (content: string, maxLength: number) => {
  if (content.length > maxLength) {
    return content.slice(0, maxLength) + "...";
  }
  return content;
};

const ListPage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);
  const [page, setPage] = useState<number>(1); // 페이지 상태 관리
  const { category } = useParams(); // useParams를 사용하여 경로 파라미터를 가져옵니다.
  const router = useRouter(); // useRouter 훅을 사용합니다.

  useEffect(() => {
    const fetchPosts = async () => {
      if (category) {
        try {
          // 페이지 번호를 쿼리 파라미터로 포함하여 요청
          const response = await axios.get(`http://localhost:8080/api/posts/${category}/${page}`);
          // 백엔드에서 페이지에 맞는 포스트를 반환하도록 구현되어 있어야 합니다.
          setPosts(response.data);
        } catch (error) {
          console.error('There was an error fetching the posts:', error);
        }
      }
    };

    fetchPosts();
  }, [category, page]); // 카테고리 또는 페이지 번호가 변경될 때마다 요청

  const handlePreviousPage = () => {
    if (page > 1) {
      setPage(page - 1);
    }
  };

  const handleNextPage = () => {
    setPage(page + 1);
  };

  // 클릭 이벤트 핸들러 함수
  const handleTitleClick = (pid: number) => {
    router.push(`/DetailPage/${pid}`); // 클릭 시 해당 pid로 라우팅합니다.
  };

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className="listpagecontent">
          <h3>카테고리: {category}</h3>
          
          <ul>
            {posts.map((post: Post) => (
              <li key={post.pid}>
                <h3><a onClick={() => handleTitleClick(post.pid)}>{post.title}</a></h3>
                <p>{post.category_name}</p>
                <p>{truncateContent(post.content, 100)}</p>
              </li>
            ))}
          </ul>
          
          <div className="pagination">
            <button onClick={handlePreviousPage} disabled={page === 1}>
              이전 페이지
            </button>
            <span>현재 페이지: {page}</span>
            <button onClick={handleNextPage}>
              다음 페이지
            </button>
          </div>
        </div>
        <RightSidebar />
      </div>
      <Footer />
    </div>
  );
};

export default ListPage;
