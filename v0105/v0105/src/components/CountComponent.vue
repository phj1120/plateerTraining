<template>
<h1>{{countObj.num}}</h1>
  <button @click="() => handleClickInc(1)"> INC </button>
  <button @click="() => handleClickInc(-1)"> DEC </button>

</template>

<script setup>
import {ref} from "vue";

const countObj = ref({num: 10})

console.log(countObj.value)

setInterval(()=>{
  countObj.value.num += 1
}, 3000)

const inc = (amount) => {
  countObj.value.num += amount
}

const handleClickInc = (amount) => {
  inc(amount)
}

</script>

<style scoped>

</style>