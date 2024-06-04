"use client"
import React, { useEffect, useState } from 'react';
import './LeftSidebar.css';
import Link from 'next/link';
import { useAuth } from '../contexts/AuthContext';

interface SearchItem {
  sid: number;
  title: string;
  date: string;
}

interface MusicChartItem {
  title: string;
  artist: string;
  date: Date;
}

function LeftSidebar() {
  const [searchRank, setSearchRank] = useState<SearchItem[]>([]);
  const [musicChart, setMusicChart] = useState<MusicChartItem[]>([]);
  const { user, logout } = useAuth();

  useEffect(() => {
    const fetchSearchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/search/latest');
        const data: SearchItem[] = await response.json();
        setSearchRank(data.slice(0, 10));
      } catch (error) {
        console.error('Error fetching search data:', error);
      }
    };

    const fetchMusicData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/music/latest');
        const data: MusicChartItem[] = await response.json();
        setMusicChart(data.slice(0, 10));
      } catch (error) {
        console.error('Error fetching music data:', error);
      }
    };

    fetchSearchData();
    fetchMusicData();
  }, []);

  return (
    <div className="left-sidebar">
      <div className="login-box">
        {user ? (
          <>
            <span>name : {user.name}</span>
            <button onClick={logout}>로그아웃</button>
          </>
        ) : (
          <button><Link href ='./LoginPage'>로그인</Link></button>
        )}
      </div>
      <br></br>
      <div className="chart-box">
        <h4>실시간 검색 순위</h4>
        <ul>
          {searchRank.map((item, index) => (
            <li key={index}>
              <strong>{item.title}</strong>
            </li>
          ))}
        </ul>
      </div>
      <br></br>
      <div className="music-box">
        <h4>음원 차트</h4>
        <ul>
          {musicChart.map((item, index) => (
            <li key={index}>
              <strong>{item.title}</strong> - {item.artist}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default LeftSidebar;
