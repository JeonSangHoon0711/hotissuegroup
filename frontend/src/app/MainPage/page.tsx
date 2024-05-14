"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';
import './MainPage.css';
import Link from 'next/link';

// 보드 제목 리스트
const boardTitles = [
  "유튜브 숏폼 Top10", 
  "유튜브 롱폼 Top10", 
  "네이버 뉴스(정치)", 
  "네이버 뉴스 (경제)", 
  "네이버 뉴스(스포츠)", 
  "네이버 뉴스(게임)", 
  "커뮤니티 게시판 최신글", 
  "커뮤니티 게시판 인기글"
];

function MainPage() {
    return (
        <div className="App">
        <Header />
        <div className="container">
            <LeftSidebar />
            <div className="main-content">
                {boardTitles.map((title, index) => (
                    <div key={index} className="board-row">
                        <div className="board">
                            <div className="board-title">{title}</div>
                            {/* 새로운 보드 추가 */}
                            <div className="sub-board">
                                <div className="sub-board-content">
                                    새로운 내용 1<br/>
                                    새로운 내용 2<br/>
                                    새로운 내용 3
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