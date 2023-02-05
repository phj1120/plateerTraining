<template>
  <v-col cols="12" md="7">
    <v-file-input multiple type="file" label="File input" v-model="files" @change="handleChangeFile"
                  accept="image/*"></v-file-input>
  </v-col>
  <v-dialog v-model="dialog">
    <v-card>
      <v-card-text>
        {{ count }}개의 파일이 실패하였습니다.
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" block @click="dialog = false">Close Dialog</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>

</template>

<script setup>
import {ref} from "vue";

const emits = defineEmits(['addFile'])
const files = ref([]);

// const files = ref([])
const dialog = ref(false)
let count = 0

const handleChangeFile = () => {
  if (!files.value) {
    return
  }
  files.value.forEach((file) => {
    if (!fileRule(file)) {
      return
    }
  })
  emits('addFile', files)
  files.value = [] // 값이 남는 것을 방지하기 위해 초기화
}

const fileRule = (file) => {
  const ableExt = ['jpg', 'png', 'gif', 'jpeg']
  const ext = file.name.split('.').pop().toLowerCase()
  if (!ableExt.includes(ext)) {
    return false
  }

  return true
}

</script>

<style scoped>

</style>
