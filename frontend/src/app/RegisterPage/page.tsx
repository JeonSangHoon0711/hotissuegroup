"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';
import './registerpage.css';

interface Post {
  idtest1: number;
  dataColumn: string;

}

const registerpage: React.FC = () => {



  return (
    <div className="App">
    <Header />
    <div className="container">
        <LeftSidebar />
        <div className='registercontent'>
  
        <form className='signupForm'>
        <div className='formRow'>
          <label htmlFor="name">이름  </label>
          <input
            type="text"
            id="name"
          />
        </div>
        <br></br>
        <div className='formRow'>
          <label htmlFor="email">이메일  </label>
          <input
            type="email"
            id="email"
            className='inputField'
          />
        </div>
        <br></br>
        <div className='formRow'>
          <label htmlFor="password"> 비밀번호 </label>
          <input
            type="password"
            id="password"

          />
        </div>
        <br></br>
        <div className='formRow'>
          <label htmlFor="passwordConfirmation">비밀번호 확인 </label>
          <input
            type="password"
            id="passwordConfirmation"

            className='inputField'
          />
        </div>
        <button type="submit" className='submitButton'>
          회원가입
        </button>
      </form>
        </div>
        <RightSidebar />
    </div>
    <Footer/>
    </div>
  );
};

export default registerpage;