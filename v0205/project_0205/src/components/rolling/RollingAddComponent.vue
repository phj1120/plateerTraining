<template>
  {{ rollingInfo }}
  <v-form>
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.title" label="Title" required></v-text-field>
        </v-col>
        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.target" label="Target" required></v-text-field>
        </v-col>

        <RollingUploadComponent :rollingInfo="rollingInfo" @addFile="addFile"></RollingUploadComponent>
        <v-col cols="12" md="7">
          <v-radio-group v-model="rollingInfo.fixFile">
            <v-row class="justify-center">
              <div class="ma-6" v-for="(preview,i) in previews" :key="i">
                <v-img class="ma-2" :src="preview.url" contain height="15vh" width="15vw"/>
                <v-row>
                  <v-radio :label="preview.name" :value="i"></v-radio>
                  <v-btn @click="clickRemoveBtn(i)">삭제</v-btn>
                </v-row>
              </div>
            </v-row>
          </v-radio-group>
        </v-col>

        <v-col cols="12" md="7">
          <v-btn class="ma-xl-auto" color="success" @click="handleClickAdd">ADD</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

</template>
<script setup>
import {ref, watch} from "vue";
import {addRolling} from "@/apis/rolling/rollingApis";
import RollingUploadComponent from "@/components/rolling/RollingUploadComponent.vue";


const emits = defineEmits(['handleMoveList'])
const rollingInfo = ref({title: null, target: null, fixFile: 0, files: []})

// 이미지 변경 시 마다 재 로딩 되는 방식
// computed 가 async 가 안되서.
const previews = ref([])

watch(rollingInfo.value.files, async () => {
  previews.value = []
  rollingInfo.value.files.forEach((file) => {
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onload = () => {
        previews.value.push({name: file.name, url: reader.result})
      }
    }
  )
})

// computed 비동기 처리 불가능
// const previews = computed(() => {
//   let images = []
//
//   rollingInfo.value.files.forEach((file) => {
//     const reader = new FileReader()
//     reader.readAsDataURL(file)
//
//     reader.onload = () => {
//       images.push({name: file.name, url: reader.result})
//     }
//   })
//
//   return images
// })

const clickRemoveBtn = (i) => {
  rollingInfo.value.files.splice(i, 1)

  // 썸네일을 삭제한 경우 첫번째 사진을 썸네일로 지정
  if (i === rollingInfo.value.fixFile) {
    rollingInfo.value.fixFile = 0
  }

  // 썸네일 이전 값을 삭제한 경우 썸네일 번호 재지정
  if (i < rollingInfo.value.fixFile) {
    rollingInfo.value.fixFile--
  }

}

const handleClickAdd = async () => {
  console.log(rollingInfo.value)
  await addRolling(rollingInfo.value)

  emits('handleMoveList')
}

const addFile = (files) => {
  for (let i = 0; i < files.length; i++) {
    rollingInfo.value.files.push(files[i])
  }
}

</script>

<style scoped>

</style>
