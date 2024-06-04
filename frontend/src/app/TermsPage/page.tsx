// TermsPage.tsx
"use client";

import React, { useState } from "react";
import Link from "next/link";
import Header from "../Header/page";
import LeftSidebar from "../LeftSidebar/page";
import RightSidebar from "../RightSidebar/page";
import Footer from "../Footer/page";
import './termspage.css'; // CSS 파일을 정확히 임포트합니다.

const TermsPage: React.FC = () => {
  const [allChecked, setAllChecked] = useState<boolean>(false);
  const [termsChecked, setTermsChecked] = useState<boolean>(false);
  const [communityRulesChecked, setCommunityRulesChecked] = useState<boolean>(false);

  const handleAllCheck = (e: React.ChangeEvent<HTMLInputElement>) => {
    const checked = e.target.checked;
    setAllChecked(checked);
    setTermsChecked(checked);
    setCommunityRulesChecked(checked);
  };

  const handleSingleCheck = (name: string) => {
    switch (name) {
      case "terms":
        setTermsChecked(!termsChecked);
        break;
      case "communityRules":
        setCommunityRulesChecked(!communityRulesChecked);
        break;
    }

    const newTermsChecked = name === "terms" ? !termsChecked : termsChecked;
    const newCommunityRulesChecked = name === "communityRules" ? !communityRulesChecked : communityRulesChecked;

    setAllChecked(newTermsChecked && newCommunityRulesChecked);
  };

  // 모든 필수 항목이 체크되었는지 검사합니다.
  const isAllRequiredChecked = termsChecked && communityRulesChecked;

  // 페이지 이동을 처리하는 함수
  const handleNextPage = (e: React.MouseEvent<HTMLAnchorElement>) => {
    if (!isAllRequiredChecked) {
      e.preventDefault(); // 필수 항목이 모두 체크되지 않았다면 이동을 방지합니다.
    }
  };

  return (
    <div className="App">
      <Header />
      <div className="container">
        <LeftSidebar />
        <div className="termsContent">
          <div className="logo">Logo</div>
          <div className="checkBox">
            <input
              type="checkbox"
              checked={allChecked}
              onChange={handleAllCheck}
            /> 전체 동의하기
          </div>
          <div className="box">실명 인증된 아이디로 가입, 이용약관(선택) 동의를 포함합니다</div>
          <div className="checkBox">
            <input
              type="checkbox"
              checked={termsChecked}
              onChange={() => handleSingleCheck("terms")}
            /> [필수] 이용약관 확인
          </div>
          <div className="box">개인정보보호법에 따라 앙까라에 회원가입 신청하시는 분께 수집하는 개인정보의 항목,
           개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 
           동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.</div>
          <div className="checkBox">
            <input
              type="checkbox"
              checked={communityRulesChecked}
              onChange={() => handleSingleCheck("communityRules")}
            /> [필수] 커뮤니티 이용수칙 확인
          </div>
          <div className="box">개인정보보호법에 따라 앙까라에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.</div>
          <div className="nextBox">
            <Link href="/RegisterPage" className={`nextButton ${!isAllRequiredChecked ? 'disabled' : ''}`} onClick={handleNextPage}>
              다음
            </Link>
          </div>
        </div>
        <RightSidebar />
      </div>
      <Footer />
    </div>
  );
};

export default TermsPage;
