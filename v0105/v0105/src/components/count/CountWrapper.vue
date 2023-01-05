<template>

  <h1>Count Wrapper Component</h1>
  <CountDisplay :count="count"></CountDisplay>
  <CountButtons @change="change"></CountButtons>
</template>

<script setup>
import CountDisplay from "@/components/count/CountDisplay.vue";
import CountButtons from "@/components/count/CountButtons.vue";

const count = ref({num : 10})

const change = (amount) => {
  count.value.num += amount
}
</script>

<style scoped>

</style>