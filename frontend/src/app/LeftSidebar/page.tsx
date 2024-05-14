import React from 'react';
import './LeftSidebar.css';
import Link from 'next/link';

function LeftSidebar() {
  const musicChart = [
    { id: 1, song: '노래 1', artist: '아티스트 1' },
    { id: 2, song: '노래 2', artist: '아티스트 2' },
    { id: 3, song: '노래 3', artist: '아티스트 3' },
    // 더 많은 노래와 아티스트 정보를 추가할 수 있습니다.
  ];
  const searchRank = [
    { id: 1, search: '축구순위'},
    { id: 2, search: '코로나 확진자'},
    { id: 3, search: '날씨'},
  ];

  return (
    <div className="left-sidebar">
      <div className="login-box">
        <button><Link href ='./LoginPage'>로그인</Link></button>
      </div>
      <br></br>
      <div className="chart-box">
        <h3>실시간 검색 순위</h3>
        <ul>
          {searchRank.map((item, index) => (
            <li key={index}>
              <strong>{item.search}</strong>
            </li>
          ))}
        </ul>
      </div>
      <br></br>
      <div className="chart-box">
        <h3>음원 차트</h3>
        <ul>
          {musicChart.map((item, index) => (
            <li key={index}>
              <strong>{item.song}</strong> - {item.artist}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default LeftSidebar;
