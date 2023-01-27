<template>
  <suspense>
    <template #fallback>
      Loading.....
    </template>
    <template #default>
      <RouterView></RouterView>
    </template>
  </suspense>
</template>

<script setup>

</script>

<style scoped>

</style>
