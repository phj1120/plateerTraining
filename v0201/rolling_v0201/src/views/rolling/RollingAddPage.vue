<template>
  <BaseLayout>
    <RollingAddComponent @handleMoveList="handleMoveList"></RollingAddComponent>
  </BaseLayout>
</template>

<script setup>
import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
import RollingAddComponent from "@/components/rolling/RollingAddComponent.vue";
import {useRouter} from "vue-router";

const router = useRouter()
const handleMoveList = () => {
  // 추가 시 검색 조건 없는 목록의 첫 페이지로 이동
  router.push({name: 'RollingListPage'})
}
</script>

<style scoped>

</style>
