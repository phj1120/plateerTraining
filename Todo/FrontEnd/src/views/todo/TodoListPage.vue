<template>
  <h1>Todo List Page</h1>
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
          <v-col>
            <v-card>
              <v-list lines="one">
                <v-list-subheader>
                  <v-btn @click="handleClickAdd">+</v-btn>
                </v-list-subheader>
                <v-divider></v-divider>
                <suspense>
                  <template #fallback>
                    <h1>Loading....</h1>
                  </template>
                  <template #default>
                    <TodoListComponent @handleClickTodo="handleClickTodo"></TodoListComponent>
                  </template>
                </suspense>
              </v-list>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import TodoListComponent from "@/components/todo/TodoListComponent.vue";
import {useRouter} from "vue-router";

const router = useRouter()

const handleClickAdd = () => {
  router.push({name: 'TodoAddPage'})
}

const handleClickTodo = (id) => {
  router.push({name: 'TodoReadPage', params: {id}})
}
</script>

<style scoped>

</style>
