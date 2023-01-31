<template>
  <h2>Rolling Detail Component</h2>
  <div>
    <li>Rolling ID : {{ rolling.id }}</li>
    <li>Rolling Name : {{ rolling.name }}</li>
    <v-btn @click="emits('moveModifyPage')">수정</v-btn>
  </div>
  <div style="height: 700px">
  </div>
  <div>
    <v-btn :to="{name: 'RollingList'}">목록으로</v-btn>
  </div>
</template>

<script setup>
import {getRolling} from "@/apis/rolling/RollingApis";

const emits = defineEmits(['moveModifyPage'])
const props = defineProps(['id'])

const rolling = await getRolling(props.id)
</script>

<style scoped>

</style>
