<template>
  <h2>Sample Test Page</h2>
  <v-text-field type="text" v-model="user.username" />
  <v-text-field v-model="user.password"/>
  <v-btn @click="handleClickLogin">Login</v-btn>
  <v-btn @click="handleClickEx1">Ex1</v-btn>
  <v-btn @click="handleClickEx2">Ex2</v-btn>
  <v-btn @click="handleClickEx3">Ex3</v-btn>
</template>

<script setup>

import axios from "axios";
import useMemberInfo from "@/store/useMemberInfo";
import authAxios from "@/util/authAxios";
import {ref} from "vue";
const user = ref({username:'test', password:'1111'})

const handleClickLogin = async () => {
  // TODO Backend 에서 body 값 가져오는 부분 못해서 일단 파라미터로 넘겨줌
  //const res = await axios.post(`http://localhost:8080/api/generate`, user);
  const res = await axios.post(`http://localhost:8080/api/generate?username=${user.value.username}&password=${user.value.password}`);
  console.log(user)
  //{access:xxxx, refresh:xxxx}
  const data = res.data

  const {saveInfo} = useMemberInfo()

  saveInfo(data.access, data.refresh)
}

const handleClickEx1 = async () => {

  const res = await authAxios.get('http://localhost:8080/api/sample/ex1')
  const data = res.data

  console.log(data)
}

const handleClickEx2 = async () => {

  const res = await authAxios.get('http://localhost:8080/api/sample/ex2')
  const data = res.data

  console.log(data)
}

const handleClickEx3 = async () => {

  const res = await authAxios.get('http://localhost:8080/api/sample/ex3')
  const data = res.data

  console.log(data)
}


</script>

<style scoped>

</style>
