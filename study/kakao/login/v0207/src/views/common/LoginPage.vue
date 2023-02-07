<template>
  <BaseLayout>
    <a id="kakao-login-btn">
      <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
           @click="loginWithKakao" alt="카카오 로그인 버튼"/>
    </a>
    <p>{{ token }}</p>
  </BaseLayout>
</template>


<script setup>
const loginWithKakao = () => {
  Kakao.Auth.authorize({
    redirectUri: 'http://localhost:3000/success',
  });

}

</script>

<style scoped>
.test {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

div {
  width: 200px;
  height: 40px;
  background-color: #fdd101;
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}
</style>
