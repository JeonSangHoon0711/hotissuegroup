"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';

// UserEntity에 맞는 interface 정의
interface User {
  uid: number;
  id: string;
  name: string;
  email: string;
  pw: string;
}

const Testpage: React.FC = () => {
  // UserEntity 객체의 배열을 관리하는 상태
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/users')
      .then((response) => {
        // 응답으로 받은 데이터를 users 상태에 설정
        setUsers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        {/* users 배열을 순회하며 각 사용자 정보를 표시 */}
        {users.map(user => (
          <div key={user.uid}>
            <p>ID: {user.id}</p>
            <p>Name: {user.name}</p>
            <p>Email: {user.email}</p>
            {/* 비밀번호는 보안상 표시하지 않음 */}
          </div>
        ))}
        <RightSidebar />
      </div>
      <Footer/>
    </div>
  );
};

export default Testpage;