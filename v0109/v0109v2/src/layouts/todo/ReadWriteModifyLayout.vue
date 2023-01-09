<template>
  <v-app id="inspire">
    <v-app-bar flat>
      <v-container class="fill-height d-flex align-center">
        <v-spacer></v-spacer>
        <v-responsive max-width="260">
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
          </v-col>
          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg">
              <suspense>
                <template #fallback>
                  Loading..
                </template>
                <template #default>
                  <slot></slot>
                </template>
              </suspense>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "ReadWriteModify"
}
</script>

<style scoped>

</style>
