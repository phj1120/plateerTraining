<template>
  <RollingLayout>
    <h1>Rolling List Page</h1>
    <v-btn @click="moveAddPage">추가</v-btn>
    <hr>
    <suspense>
      <template #default>
        <RollingListComponent @moveDetailPage="moveDetailPage"></RollingListComponent>

      </template>

      <template #fallback>Loading..</template>

    </suspense>

  </RollingLayout>
</template>

<script setup>
import RollingListComponent from "@/components/rolling/RollingListComponent.vue";
import {useRouter} from "vue-router";
import RollingLayout from "@/layouts/default/RollingLayout.vue";

const router = useRouter();

const moveAddPage = () => {
  router.push({name: 'RollingAdd'})

}

const moveDetailPage = (id) => {
  router.push({name: 'RollingDetail', params: {id: id}})
}

</script>

<style scoped>

</style>

