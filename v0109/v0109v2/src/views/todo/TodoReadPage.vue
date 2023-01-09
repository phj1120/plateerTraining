<template>
  <h1>Todo Read Page</h1>
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
        <v-btn @click="handleClickModify">수정</v-btn>
        <v-btn @click="handleClickDelete(id)">삭제</v-btn>
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
                  <TodoReadComponent></TodoReadComponent>
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
import {useRoute, useRouter} from "vue-router";
import TodoReadComponent from "@/components/todo/TodoReadComponent.vue";
import {deleteTodo} from "@/apis/todoApis";

const route = useRoute();
const router = useRouter();
const {id} = route.params

const handleClickModify = () => {

  console.log('hi')
}

const handleClickDelete = (id) => {
  deleteTodo(id).then(() => {
      return router.push({name: 'TodoListPage'})
    }
  )
}


</script>

<style scoped>

</style>
