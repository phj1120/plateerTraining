<template>
  <h1>Todo Wrapper</h1>
  <TodoInput></TodoInput>
  <TodoList></TodoList>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="todo.content"
            label="CONTENT"
          ></v-text-field>
        </v-col>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="todo.writer"
            label="WRITER"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-btn @click="addTodo()">Add</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

  <v-table>
    <thead>
    <tr>
      <th class="text-left">
        ID
      </th>
      <th class="text-left">
        CONTENT
      </th>
      <th class="text-left">
        WRITER
      </th>
    </tr>
    </thead>
    <tbody>
    <tr
      v-for="todo in todos"
      :key="todo.id"
    >
      <td>{{ todo.id }}</td>
      <td>{{ todo.content }}</td>
      <td>{{ todo.writer }}</td>
      <v-btn @click="removeTodo(todo.id)">x</v-btn>
    </tr>
    </tbody>
  </v-table>
</template>

<script setup>

import {ref} from "vue";
import TodoInput from "@/components/todo/TodoInput.vue";
import TodoList from "@/components/todo/TodoList.vue";

const id = ref(1)
const todo = ref({id:id.value, content:'', writer:''})
const todos = ref([])

const addTodo = () => {
  todos.value.push({id:id.value++, writer:todo.value.writer, content: todo.value.content})
}

const removeTodo = (id)=>{
  todos.value = todos.value.filter(todo=> todo.id !== id)
}
</script>

<style scoped>

</style>
