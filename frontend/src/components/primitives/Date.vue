<template>
    <div>
        <div v-if="editMode">
            <v-menu
                ref="menu"
                v-model="menu"
                :close-on-content-click="false"
                :return-value.sync="date"
                transition="scale-transition"
                offset-y
                min-width="auto"
            >
                <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                            v-model="date"
                            :label="label"
                            prepend-icon="mdi-calendar"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                    ></v-text-field>
                </template>
                <v-date-picker
                        v-model="date"
                        no-title
                        scrollable
                >
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="menu = false">
                        Cancel
                    </v-btn>
                    <v-btn text color="primary" @click="$refs.menu.save(date)">
                        OK
                    </v-btn>
                </v-date-picker>
            </v-menu>
        </div>
        <div v-else>
            {{label}} :  {{value}}
        </div>
    </div>
</template>

<script>  
    export default {
        name: 'Date',
        components:{
        },
        props: {
            value: Object,
            editMode: Boolean,
            label: String
        },
        data: () => ({
            menu: false,
            date: new Date().toISOString().substr(0, 10),
        }),
        created() {
            if(!this.value) {
                this.value = this.date;
            }
        },
        watch: {
            date() {
                const fullDate = new Date(this.date + 'T00:00:00.000Z').toISOString();
                this.value = fullDate
                this.change();
            }
        },
        methods:{
            change(){
                this.$emit("input", this.value);
            }
        }
    }
</script>
