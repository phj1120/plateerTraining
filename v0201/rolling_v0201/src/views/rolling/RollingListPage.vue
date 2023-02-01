<template>
  <BaseLayout>
    <div :key="componentKey">
      <RollingListComponent :pageSearch="pageSearch" @handleMoveAdd="handleMoveAdd"
                            @handleMoveDetail="handleMoveDetail" @handleChangePage="handleChangePage"
                            @handleRollingSearch="handleRollingSearch"></RollingListComponent>
    </div>
  </BaseLayout>
</template>

<script setup>
import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
import RollingListComponent from "@/components/rolling/RollingListComponent.vue";
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";

const route = useRoute()
const router = useRouter()

const componentKey = ref(0);
const pageSearch = ref({
  page: route.query.page,
  size: route.query.size,
  types: route.query.types,
  keyword: route.query.keyword
})

const handleMoveAdd = () => {
  router.push({name: 'RollingAddPage', query: pageSearch.value})
}

const handleMoveDetail = (id) => {
  router.push({name: 'RollingDetailPage', params: {id: id}, query: pageSearch.value})
}

const handleChangePage = (pageNumber) => {
  // 이동할 페이지 pageSearch 에 저장
  pageSearch.value.page = pageNumber
  router.push({name: 'RollingListPage', query: pageSearch.value})
}

//searchInfo { types: null, keyword: null }
const handleRollingSearch = (searchInfo) => {
  // 현재 검색 상자에 있는 값 pageSearch 에 저장
  pageSearch.value.keyword = searchInfo.keyword
  pageSearch.value.types = searchInfo.types
  pageSearch.value.page = 1

  // 페이지 이동
  router.push({name: 'RollingListPage', query: pageSearch.value})
}

router.beforeEach((to, from, next) => {
  //
  pageSearch.value.page = to.query.page
  pageSearch.value.size = to.query.size
  pageSearch.value.types = to.query.types
  pageSearch.value.keyword = to.query.keyword

  // 컴포넌트 갱신
  componentKey.value++

  next()
})
</script>

<style scoped>

</style>
