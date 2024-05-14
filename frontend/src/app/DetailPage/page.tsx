"use client"
import React, { useState } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Link from 'next/link';
import './detailpage.css';
import Footer from '../Footer/page';

type Post = {
  pid: number;
  title: string;
  content: string;
  category_name: string;
};

type Comment = {
  id: number;
  user: string;
  date: string;
  content: string;
};

const mockPosts: Post[] = [
  {
    pid: 1,
    title: "",
    content: "조회수 14,660,716회  2023. 6. 9.",
    category_name: "youtube",
  }
];

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
  const [posts, setPosts] = useState<Post[]>(mockPosts);
  const [comments, setComments] = useState<Comment[]>(mockComments);

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className='detailpagecontent'>
          <div className='posttitle'>제목 : 𝐏𝐥𝐚𝐲𝐥𝐢𝐬𝐭 질리도록 듣는 히트곡엔 그 이유가 있다𝐅𝐞𝐚𝐭. 𝐋𝐚𝐮𝐯, 𝐋𝐚𝐧𝐲, 𝐇𝐨𝐧𝐧𝐞, 𝐤𝐞𝐬𝐡𝐢, 𝐏𝐞𝐝𝐞𝐫 𝐄𝐥𝐢𝐚𝐬, 𝐓𝐫𝐨𝐲𝐞 𝐒𝐢𝐯𝐚𝐧, 𝐂𝐡𝐚𝐫𝐥𝐢𝐞 𝐏𝐮𝐭𝐡</div>
          <div className='detailpagepost'>
            {posts.map((post) => (
              <div key={post.pid} className='detailpost'>
                <h2>{post.title}</h2>
                <p>{post.content}</p>
                <p>Category: {post.category_name}</p>
                <div className='youtubePlayer'>
                  <iframe
                    width="560"
                    height="315"
                    src="https://www.youtube.com/embed/x6i3_LfeTjY"
                    title="YouTube video player"
                    frameBorder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowFullScreen>
                  </iframe>
                </div>
              </div>
            ))}
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