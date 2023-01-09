<template>
  <h1>Todo Add Page</h1>
  <v-app id="inspire">
    <v-app-bar flat>
      <v-container class="fill-height d-flex align-center">
        <v-spacer></v-spacer>
        <v-responsive max-width="260">
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
          </v-col>
          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg">
              <suspense>
                <template #fallback>
                  Loading..
                </template>
                <template #default>
                  <TodoAddComponent @handleClickAdd="handleClickAdd"></TodoAddComponent>
                </template>
              </suspense>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>

import TodoAddComponent from "@/components/todo/TodoAddComponent.vue";
import {useRouter} from "vue-router";
import {postTodo} from "@/apis/todoApis";

const router = useRouter();

const handleClickAdd = (todo) => {
  postTodo(todo).then(() => {
      router.push({name: "TodoListPage"})
    }
  )
}

</script>

<style scoped>

</style>
