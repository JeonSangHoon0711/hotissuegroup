"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';

interface Post {
  idtest1: number;
  dataColumn: string;
}

const Testpage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/tests')
      .then((response) => {
        setPosts(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      안녕1
      {posts.map((post) => (
        <div key={post.idtest1}>
          <h2>
            {post.idtest1} - {post.dataColumn}
          </h2>
        </div>
      ))}
      <br></br>
      안녕2
    </div>
  );
};

export default Testpage;