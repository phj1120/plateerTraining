<template>
  <v-dialog class="justify-center" v-model="dialog">
    <v-card style="margin: 0 auto; width: 50vw">
      <v-card-text>
        롤링페이퍼 {{ props.id }}번이 정상적으로 처리되었습니다.
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" block @click="clickDialogClose">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "RollingDialogModify"
}
</script>

<style scoped>

</style>
