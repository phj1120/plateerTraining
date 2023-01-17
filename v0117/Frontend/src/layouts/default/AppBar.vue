<template>
  <v-app-bar flat>
    <v-btn>목록</v-btn>
    <v-btn>로그인</v-btn>
    <v-btn>로그아웃</v-btn>
  </v-app-bar>
</template>

<script setup>
import {ref} from "vue";
import useMemberInfo from "@/store/useMemberInfo";

const showMenus = ref([
  {showName: '목록', name: 'TodoListPage', type: 'all'},
  {showName: '로그인', name: 'TodoListPage', type: 'logined'},
  {showName: '로그아웃', name: 'TodoListPage', type: 'logouted'},
])

const memberStore = useMemberInfo();

const tokens = memberStore.getTokens()

console.log('tokens: ')
console.log(tokens.value);

</script>
