"use client"
import React, { useEffect, useState } from 'react';
import './LeftSidebar.css';
import Link from 'next/link';

// 실시간 검색어 타입 정의
interface SearchItem {
  sid: number;
  title: string;
  date: string;
}

// MusicChartItem 타입 정의
interface MusicChartItem {
  title: string;
  artist: string;
  date: Date;
}

function LeftSidebar() {
  // 실시간 검색어와 음악 차트의 타입을 명시적으로 지정
  const [searchRank, setSearchRank] = useState<SearchItem[]>([]);
  const [musicChart, setMusicChart] = useState<MusicChartItem[]>([]);

  useEffect(() => {
    // API 요청을 통해 실시간 검색어 데이터를 받아오는 함수
    const fetchSearchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/search/latest');
        const data: SearchItem[] = await response.json();
        // 상위 10개 항목만 설정
        setSearchRank(data.slice(0, 10));
      } catch (error) {
        console.error('Error fetching search data:', error);
      }
    };

    // API 요청을 통해 음악 데이터를 받아오는 함수
    const fetchMusicData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/music/latest');
        const data: MusicChartItem[] = await response.json();
        // 상위 10개 항목만 설정
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
        <button><Link href ='./LoginPage'>로그인</Link></button>
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
