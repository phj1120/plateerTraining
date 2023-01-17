<template>
  <h2>Todo List Component</h2>
  <h3>{{ query }}</h3>

  <div>
    <ul>
      <li v-for="todo in data.dtoList" :key="todo.id" @click="emits('moveTodo', todo.id)">
        {{ todo }}
      </li>
    </ul>
  </div>

  <ul class="paging">
    <li v-for="page in data.pageNumList">
      <v-btn @click="()=>emits('movePage', page) ">{{ page }}</v-btn>
    </li>
  </ul>

</template>

<script setup>

import authAxios from "@/util/authAxios";

const props = defineProps(['query'])
const emits = defineEmits(['movePage', 'moveTodo'])

const res = await authAxios.get(`http://localhost:8080/api/todos/list?page=${props.query.page || 1}`)
const data = res.data

</script>

<style scoped>
.paging {
  display: flex;

}

.paging li {
  margin-left: 0.3em;

}

</style>
