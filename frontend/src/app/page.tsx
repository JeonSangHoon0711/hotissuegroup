"use client"
// src/app/page.tsx
import React from 'react';
import Link from 'next/link';
import Header from './Header/page';
import LeftSidebar from './LeftSidebar/page';
import RightSidebar from './RightSidebar/page';
import Footer from './Footer/page';
import '@/app/app.css'; // 절대 경로 사용
import MainPage from './MainPage/page';

const App = () => {
  return (
    <MainPage />
  );
};

export default App;