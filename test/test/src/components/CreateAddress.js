import {useEffect, useState} from "react";
import {Formik, Form, Field} from "formik";
import {useNavigate} from "react-router";
import {createAddress, getListProvinceAPI} from "../services/addressService";
import Swal from "sweetalert2";


function CreateAddress() {
    const [inputValue, setInputValue] = useState();
    const navigate = useNavigate();
    const [listProvince, setListProvince] = useState([])
    const [listDistrict, setListDistrict] = useState([])

    function handleSubmit(e) {
        const getValue = {e}
        createAddress(e);
        Swal.fire({
            icon: "success",
            timer: 2000,
            title: "Thêm mới thành công!",
            showConfirmButton: false
        })
    }

    function handleChangeDistrict(e) {
        const address = listProvince.filter((item) =>
            item.code == e.target.value
        )
      if (address.length!=0){
          console.log(address[0].districts)
          setListDistrict(address[0].districts)
      }else {
          setListDistrict([])
      }

    }

    const getListProvince = async () => {
        setListProvince(await getListProvinceAPI())

    }

    useEffect(() => {
        getListProvince()
    }, [])
    return (
        <Formik initialValues={{
            fullName: '',
            province: '',
            district: '',
            address: '',
            phone: '',
            email: ''
        }}
                onSubmit={(values) => {
                    handleSubmit(values);
                    navigate("/")
                }}>
            <Form>
                <div className={'row container mainForm createForm'}>
                    <div className={"col-sm-12 col-md-12 col-lg-12 borderForm" }>
                        <h3>Thêm mới địa chỉ</h3>
                    </div>
                    <div className={'borderForm'}>
                    <div className={"col-sm-12 col-md-12 col-lg-12"}>
                        <p><span><i className="fa-regular fa-user"></i> </span><label htmlFor='fullName' > Họ và tên</label></p>
                        <Field name={'fullName'} id={'fullName'} type={'text'} placeholder="Mai Phước Tài"/>
                    </div>
                    <div className={"col-sm-12 col-md-12 col-lg-12"}>

                        <p><span><i className="fa-solid fa-phone"></i></span><label htmlFor='phone'>Số điện thoại</label></p>
                        <Field name={'phone'} id={'phone'} type={'text'}/>
                    </div>
                    <div className={"col-sm-12 col-md-12 col-lg-12"}>

                        <p><span><i className="fa-regular fa-envelope"></i></span><label htmlFor='email'>Email</label></p>
                        <Field name={'email'} id={'email'} type={'text'}/>
                    </div>
                    <div className={"col-sm-12 col-md-12 col-lg-12"}>
                        <p><span><i className="fa-solid fa-location-dot"></i></span><label htmlFor='province'>Tỉnh, thành phố</label></p>

                        <Field as="select" name={'province'} id={'province'} onBlur={handleChangeDistrict}>
                            <option>Tỉnh</option>
                            {listProvince.map((item, index) =>
                                <option key={index} value={item.code}>{item.name}</option>
                            )}
                        </Field>
                    </div>
                    <div className={"col-sm-12 col-md-12 col-lg-12"}>
                        <p><span><i className="fa-solid fa-location-dot"></i></span><label htmlFor='district'>Quận, huyện</label></p>
                        <Field as="select" name={'district'} id={'district'}>
                            <option>Huyện</option>
                            {listDistrict.map((item, index) =>
                                <option key={index} value={item.code}>{item.name}</option>
                            )}
                        </Field>
                    </div>
                    <div className={"col-sm-12 col-md-12 col-lg-12"}>
                        <p><span><i className="fa-solid fa-location-dot"></i></span><label htmlFor='address'>Địa chỉ cụ thể</label></p>
                        <Field name={'address'} id={'address'} type={'text'}/>
                    </div>

                    <button type={"submit "} className={'buttonCreate'}>Lưu thông tin   </button>
                    </div>
                </div>
            </Form>

        </Formik>
    );
}

export default CreateAddress;