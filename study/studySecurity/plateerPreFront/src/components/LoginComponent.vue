<template>
  <h2>Login Component </h2>


  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="userInfo.id"
      label="User ID"
      required
    ></v-text-field>
    <v-text-field
      v-model="userInfo.pw"
      label="User PW"
      required
    ></v-text-field>
    <v-btn
      color="success"
      class="mr-4"
      @click="handleClick"
    >
      Login
    </v-btn>
  </v-form>

  <v-btn @click="handleClick">Generate Key</v-btn>
</template>

<script setup>

import axios from "axios";
import useMemberInfo from "@/store/useMemberInfo";
import {ref} from "vue";


const userInfo = ref({id: '', pw: ''})



const handleClick = async () => {
  const res = await axios.post(`http://localhost:8080/api/generate`, userInfo.value)
  // const res = await axios.post(`http://localhost:8080/api/generate?memberId=${memberId.value}`)

  //{access:xxxx, refresh:xxxx}
  const data = res.data

  console.log(data)

  const {saveInfo} = useMemberInfo()

  saveInfo(data.access, data.refresh)

}

</script>

<style scoped>

</style>
