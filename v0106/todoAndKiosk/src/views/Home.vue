<template>
  <h1>Home Page</h1>
</template>

<script setup>
import { postTodo } from '@/apis/todoAPI';


const todo = { titile: 'Title1', writer: 'user1' }

setTimeout(() => {
  postTodo(todo).then(result => {
    console.log(result)
  }).catch(err => {
    console.log(err)
  })
}, 1000)

</script>
