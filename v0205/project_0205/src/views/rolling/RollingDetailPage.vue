<template>
  <BaseLayout>
    <RollingDetailComponent :id="id" @handleMoveModify="handleMoveModify"
                            @handleMoveList="handleMoveList"></RollingDetailComponent>
  </BaseLayout>
</template>

<script setup>
import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
import RollingDetailComponent from "@/components/rolling/RollingDetailComponent.vue";
import {useRoute, useRouter} from "vue-router";

const route = useRoute()
const router = useRouter()
const id = route.params.id

const handleMoveList = () => {
  router.push({name: 'RollingListPage', query: route.query})
}

const handleMoveModify = () => {
  router.push({name: 'RollingModifyPage', query: route.query})
}
</script>

<style scoped>

</style>
