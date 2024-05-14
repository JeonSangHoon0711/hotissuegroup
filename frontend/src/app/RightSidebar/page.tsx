import React from 'react';
import './RightSidebar.css';

function RightSidebar() {
    const popularPosts = [
        { id: 1, title: '게시글 1', views: 150 },
        { id: 2, title: '게시글 2', views: 120 },
        { id: 3, title: '게시글 3', views: 100 }
    ];

    return (
        <div className="right-sidebar">
            <h3>인기 게시글</h3>
            <ul>
                {popularPosts.map(post => (
                    <li key={post.id}>
                        <a href={`/post/${post.id}`}>{post.title}</a>
                        <span className="views">조회수: {post.views}</span>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default RightSidebar;