import React from "react";
import Link from 'next/link';
import Header from './Header/page';
import LeftSidebar from './LeftSidebar/page';
import RightSidebar from './RightSidebar/page';
import Footer from './Footer/page';
import './app.css';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router } from 'react-router-dom';

const App = () => {
  return (
    
  <div className="App">
  <Header />
  <div className="container">
      <LeftSidebar />
      <div>
        <h1>홈페이지</h1>
        <Link href='./testpage'><h2>Test</h2></Link>
        <Link href='./ListPage'><h2>List</h2></Link>
        <Link href='./DetailPage'><h2>Post</h2></Link>
        <Link href='./LoginPage'><h2>Login</h2></Link>
        <Link href='./MainPage'><h2>Main</h2></Link>
      </div>
      <RightSidebar />
  </div>
  
  <Footer/>
  asdf
  </div>
  

  );
};

export default App;


