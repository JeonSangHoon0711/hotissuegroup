import React from 'react';
import './Header.css'; // 헤더 전용 CSS 파일
import Link from 'next/link';

function Header() {
    return (
        <header>
            <div className="container">
                <div className="logo">
                    <img src="https://github.com/guswnsj/ankara/blob/main/public/img/Logo.png?raw=true" alt="앙까라 로고" style={{ height: '70px', verticalAlign: 'middle' }} />
                </div>
                <h1 className="title"><Link href='/'>ㅇㄲㄹ</Link></h1>
                <nav>
                    <ul>
                        <li><a href="About.html">알림</a></li>
                        <li><a href="Photos.html">북마크</a></li>
                        <li><a href="Contact.html">검색</a></li>
                    </ul>
                </nav>
            </div>
        </header>
    );
}

export default Header;