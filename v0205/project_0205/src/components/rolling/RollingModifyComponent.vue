<template>
  <v-form>
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.id" label="ID" readonly></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.title" label="Title" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.target" label="Target" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.imgSrc" label="Image" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.wno" label="Writer" readonly></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.createDt" label="Create Date" readonly></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-btn class="ma-2 ma-xl-auto" color="error" @click="clickDeleteBtn" style="float: right">DEL</v-btn>
          <v-btn class="ma-2 ma-xl-auto" color="success" @click="clickModifyBtn" style="float: right">MOD</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

  <v-dialog class="justify-center" v-model="modifyDialog">
    <v-card style="margin: 0 auto; width: 50vw">
      <v-card-text>
        롤링페이퍼 {{ props.id }}번이 정상적으로 수정 되었습니다.
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" block @click="handleClickModifyDialog">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>

  <v-dialog class="justify-center" v-model="deleteDialog">
    <v-card style="margin: 0 auto; width: 50vw">
      <v-card-text>
        롤링페이퍼 {{ props.id }}번이 정상적으로 삭제 되었습니다.
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" block @click="handleClickDeleteDialog">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup>
import {deleteRolling, getRolling, modifyRolling} from "@/apis/rolling/RollingApis";
import {onMounted, ref} from "vue";

const props = defineProps(['id'])
const emits = defineEmits(['handleMoveDetail', 'handleMoveList'])
const modifyDialog = ref(false)
const deleteDialog = ref(false)
const rolling = ref({})

const getRollingOne = async () => {
  const res = await getRolling(props.id)
  rolling.value = res.data
}

// 수정
const clickModifyBtn = async () => {
  await modifyRolling(rolling.value)
  modifyDialog.value = true
}

const handleClickModifyDialog = () => {
  modifyDialog.value = false
  emits('handleMoveDetail')
}

// 삭제
const clickDeleteBtn = async () => {
  await deleteRolling(props.id)
  deleteDialog.value = true
}

const handleClickDeleteDialog = () => {
  deleteDialog.value = false
  emits('handleMoveList')
}

onMounted(() => {
  getRollingOne()
})
</script>

<style scoped>

</style>
