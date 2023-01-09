<template>
    <h1>Todo Modify Page</h1>
    <ReadWriteModifyLayout>
      <template #default>
        <TodoModifyComponent @moveTodoListPage="moveTodoListPage"
                             @moveTodoReadPage="moveTodoReadPage"></TodoModifyComponent>
      </template>
    </ReadWriteModifyLayout>
</template>

<script setup>
import ReadWriteModifyLayout from "@/layouts/todo/ReadWriteModifyLayout.vue";
import TodoModifyComponent from "@/components/todo/TodoModifyComponent.vue";
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import {getTodo} from "@/apis/todoApis";

const route = useRoute()
const router = useRouter()
const {id} = route.params
const todo = ref({})
getTodo(id).then((result) => {
  todo.value = result
})

const moveTodoListPage = () => {
  router.push({name: "TodoListPage"})
}

const moveTodoReadPage = (id) => {
  router.push({name: "TodoReadPage", params: id})
}

</script>

<style scoped>

</style>
