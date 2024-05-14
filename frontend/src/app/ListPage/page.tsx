"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Link from 'next/link';
import './ListPage.css';
import Footer from '../Footer/page';
type Post = {
  pid: number;
  title: string;
  content: string;
  category_name: string;
};

const mockPosts: Post[] = [
  // Add some sample posts here
  {
    pid: 1,
    title: "This is a sample post title 1",
    content: "This is the content of the first sample post. It can be a longer paragraph to test truncation.",
    category_name: "Sample Category",
  },
  {
    pid: 2,
    title: "This is a sample post title 2",
    content: "This is the content of the second sample post. It can be used to test how multiple posts are displayed.",
    category_name: "Another Category",
  },
  // Add more sample posts as needed
];

function truncateContent(content: string, maxLength: number) {
  if (content.length > maxLength) {
    return content.slice(0, maxLength) + "...";
  }

  return content;
}

const ListPage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>(mockPosts); // Use mockPosts for testing

  // Remove the useEffect hook since we're not fetching data

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className='listpagecontent'>
          <ul>
            {posts.map((post: Post) => (
              <li key={post.pid}>
                <h2>{post.title}</h2>
                <p>{post.category_name}</p>
                <p >asdf</p>

              </li>
            ))}
          </ul>

        </div>
        <RightSidebar />
      </div>
      <Footer />
    </div>
  );
};
export default ListPage;

