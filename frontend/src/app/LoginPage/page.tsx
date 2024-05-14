"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';
import './loginpage.css';
import Link from 'next/link';

interface Post {
  idtest1: number;
  dataColumn: string;
}

const LoginPage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);

  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");




  return (
    <div className="App">
    <Header />
    <div className="container">
        <LeftSidebar />
      
        <div className='logincontent'>
  
          <form className='loginForm'>
          <div className='formRow'>
            <label htmlFor="email">이메일:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className='formRow'>
            <label htmlFor="password">비밀번호:</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <div className='formRowLoginReg'>
            <button type="submit">로그인</button>
            <button type="button" >
              <Link href ='./RegisterPage'> 회원가입</Link>
            </button>
          </div>
        </form>
      
        </div>
        <RightSidebar />
    </div>
    <Footer/>
    </div>
  );
};

export default LoginPage;

