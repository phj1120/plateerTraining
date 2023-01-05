<template>
  <h1>Count Wrapper Component</h1>
  <MemoDisplay @add="add"></MemoDisplay>
  <MemoAddButtons :count="count"></MemoAddButtons>
  <ul v-for="word in arr"   >
    <MemoDeleteButtons @change="change"></MemoDeleteButtons>
  </ul>

</template>

<script setup>
import {ref} from "vue";
import MemoAddButtons from "@/components/memopad/MemoAddButtons.vue";
import MemoDeleteButtons from "@/components/memopad/MemoElement.vue";
import MemoDisplay from "@/components/memopad/MemoDisplay.vue";

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