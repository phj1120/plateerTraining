<template>
  <button @click="() => add(message)"> add </button>
  <input v-model="message">
  <ul v-for="word in arr"   >
    <li>{{word.str}}<button @click="() => remove(word.seq)"> remove </button></li>
  </ul>
  <h1>{{message}}</h1>
</template>

<script setup>

import {ref} from "vue";

const seq = ref(2)
const arr = ref([
  {"seq":1, "str":"AAA"},
  {"seq":2, "str":"BBB"}
])
const message = ref("")

const add = (word) => {
  console.log(word)
  arr.value.push({"seq":++seq.value, "str": word})
}

const remove = (seq) =>{
  const result = arr.value.filter(ele => ele.seq !== seq)

  arr.value = result
}

</script>

<style scoped>

</style>