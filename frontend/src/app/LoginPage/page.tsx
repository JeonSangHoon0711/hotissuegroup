"use client"
import React, { useState } from 'react';
import axios from 'axios';
import Header from "../Header/page";
import LeftSidebar from '../LeftSidebar/page';
import RightSidebar from '../RightSidebar/page';
import Footer from '../Footer/page';
import './loginpage.css';
import Link from 'next/link';
import { useAuth } from '../contexts/AuthContext';
import { useRouter } from 'next/navigation'; 

interface Post {
  idtest1: number;
  dataColumn: string;
}

const LoginPage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);
  const [id, setId] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const { login } = useAuth();
  const router = useRouter();

  // 로그인 처리 함수
  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/users/login', {
        id,
        pw: password,
      });

      const { uid, name, id: userId } = response.data; // 서버 응답에서 필요한 정보를 추출
      console.log(response.data);
      // Context의 login 함수를 사용하여 사용자 정보 저장
      login({ uid, name, id: userId }); // 서버로부터 받은 사용자 정보를 저장
      alert("로그인에 성공하였습니다.");
      router.push('/'); // 로그인 성공 시 / 주소로 이동
    } catch (error) {
      console.error(error);
      if (axios.isAxiosError(error)) {
        // AxiosError의 경우
        if (error.response) {
          const { status, data } = error.response;
          if (status === 404) {
            alert("사용자를 찾을 수 없습니다.");
          } else if (status === 401) {
            alert("잘못된 비밀번호입니다.");
          } else {
            alert("로그인 중 오류가 발생하였습니다."); // 다른 모든 에러에 대한 기본 메시지
          }
        } else {
          console.error(error);
          alert('로그인 실패: 서버 응답이 없습니다.');
        }
      } else if (error instanceof Error) {
        // 일반적인 Error 인스턴스인 경우
        console.error(error.message);
        alert('로그인 실패: ' + error.message);
      } else {
        // 그 외 알 수 없는 오류의 경우
        console.error('알 수 없는 오류', error);
        alert('알 수 없는 오류로 로그인 실패');
      }
    }
  };

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className='logincontent'>
          <form className='loginForm' onSubmit={handleLogin}>
            <div className='formRow'>
              <label htmlFor="id">ID</label>
              <input
                type="text"
                id="id"
                value={id}
                onChange={(e) => setId(e.target.value)}
              />
            </div>
            <div className='formRow'>
              <label htmlFor="password">비밀번호</label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            <div className='formRowLoginReg'>
              <button type="submit">로그인</button>
              <button type="button">
                <Link href='./RegisterPage'> 회원가입</Link>
              </button>
            </div>
          </form>
        </div>
        <RightSidebar />
      </div>
      <Footer />
    </div>
  );
};

export default LoginPage;
