<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
import MyHelloWorld from "@/components/MyHelloWorld.vue";
import CountComponent from "@/components/CountComponent.vue";
import CountWrapper from "@/components/count/CountWrapper.vue";
import MemoPad1 from "@/components/MemoPad1.vue"
</script>

<template>
  <MemoPad1></MemoPad1>
  <!--  <div>-->
<!--  <CountWrapper></CountWrapper>-->
<!--  </div>-->
<!--<CountComponent></CountComponent>-->
<!--<MyHelloWorld></MyHelloWorld>-->
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
