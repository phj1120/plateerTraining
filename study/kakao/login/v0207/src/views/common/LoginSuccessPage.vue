<template>
  {{ infos }}
</template>

<script setup>
import {ref} from "vue";

const infos = ref({});
const token = '~~'

Kakao.Auth.setAccessToken(token);
infos.value = Kakao.API.request({
  url: '/v2/user/me',
  data: {
    property_keys: ['kakao_account.email'],
  },
})
  .then((response) => {
    console.log(response)
  })
  .catch((error) => {
    console.log(error)
  })

</script>

<style scoped>

</style>
