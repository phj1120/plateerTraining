<template>
  {{ countObj }}
</template>
<script>
// 상태
import {ref} from "vue";

const countObj = ref({num: 10})

console.log(countObj.value)

// setInterval(()=>{
//   countObj.value.num += 1
// }, 3000)

// 메서드
const inc = (amount) => {
  countObj.value += amount;
};

// 이벤트
const handleClickInc = (amount) => {
  inc(amount)
}
</script>

<style scoped>

</style>