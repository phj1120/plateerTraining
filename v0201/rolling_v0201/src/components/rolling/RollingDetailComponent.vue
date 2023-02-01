<template>
  <v-table>
    <tbody>
    <tr>
      <th class="text-center">ID</th>
      <td class="text-center">{{ rolling.id }}</td>
    </tr>

    <tr>
      <th class="text-center">Title</th>
      <td class="text-center">{{ rolling.title }}</td>
    </tr>

    <tr>
      <th class="text-center">Target</th>
      <td class="text-center">{{ rolling.target }}</td>
    </tr>

    <tr>
      <th class="text-center">Image</th>
      <td class="text-center">{{ rolling.imgSrc }}</td>
    </tr>

    <tr>
      <th class="text-center">Writer</th>
      <td class="text-center">{{ rolling.writer }}</td>
    </tr>

    <tr>
      <th class="text-center">Create Date</th>
      <td class="text-center">{{ rolling.createDt }}</td>
    </tr>

    <tr>
      <th class="text-center"></th>
      <td class="text-center">
        <v-btn class="ma-4" color="success" @click="clickListBtn">목록</v-btn>
        <v-btn class="ma-4" color="info" @click="clickModifyBtn">수정</v-btn>
      </td>
    </tr>
    </tbody>
  </v-table>
</template>

<script setup>
import {getRolling} from "@/apis/rolling/RollingApis";
import {onMounted, ref} from "vue";

const rolling = ref({})
const props = defineProps(['id'])
const emits = defineEmits(['handleMoveModify', 'handleMoveList'])

const clickListBtn = () => {
  emits('handleMoveList')
}

const clickModifyBtn = () => {
  emits('handleMoveModify')
}

const getRollingOne = async () => {
  const res = await getRolling(props.id)
  rolling.value = res.data
}

// TODO 실행 해 봤는데 둘의 차이를 모르겠음
// getRollingOne()
onMounted(() => {
  getRollingOne()
})
</script>

<style scoped>
</style>
