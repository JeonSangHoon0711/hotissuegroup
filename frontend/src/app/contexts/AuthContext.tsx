"use client"
// contexts/AuthContext.js
import React, { createContext, useContext, useState, ReactNode } from 'react';

interface UserInfo {
  uid: number;
  name: string;
  id: string;
  // 필요한 다른 필드들 추가
}

const AuthContext = createContext<{
  user: UserInfo | null;
  login: (userInfo: UserInfo) => void;
  logout: () => void;
} | null>(null);

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [user, setUser] = useState<UserInfo | null>(null); // 사용자 정보 상태

  // 로그인 상태 변경 함수
  const login = (userInfo: UserInfo) => {
    setUser(userInfo);
  };

  // 로그아웃 상태 변경 함수
  const logout = () => {
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// Custom Hook
export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth는 AuthProvider 내부에서 사용해야 합니다.');
  }
  return context;
};
