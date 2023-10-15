import React, {useEffect} from 'react';
import {useRecoilState, useRecoilValue, useSetRecoilState} from 'recoil';


import {addressListState} from "./AddressListState";
import {deleteAddressAPI, getListAddress} from "../services/addressService";
import {Link} from "react-router-dom";
import Swal from "sweetalert2";

function ListAddress() {
    const [listAddress,setListAddress] = useRecoilState(addressListState);
    const getList=async ()=>{
        setListAddress(await getListAddress())
    }
    const deleteAddress=(item)=>{
        Swal.fire({
            title: 'Bạn có muốn xóa khách hàng ' + item.fullName + " ?",
            icon: 'error',
            showCancelButton: true,
            confirmButtonText: 'Có',
            cancelButtonText: 'Không',
            reverseButtons: true
        }).then(async (res) => {
            if (res.isConfirmed) {
                await deleteAddressAPI(item.id)
                setListAddress(await getListAddress())
                Swal.fire({
                    icon: 'success',
                    title: 'Xóa thành công!',
                    showConfirmButton: false,
                    timer: 1500
                })

            }
        })
    }
    useEffect(()=>{
       getList();
    },[])
    return (
        <div className={'row container mainForm'}>
            <div className={'col-sm-12 col-md-12 col-lg-12 borderForm listForm'}>
                <div className={"center btn-group-vertical"}>
                    <img src="https://th.bing.com/th/id/OIP.xXytQcboCykCCihlDTIL_AHaHa?pid=ImgDet&w=512&h=512&rs=1" alt="" width={"200px"}/>
                    <Link to={'/create'}> <button>Thêm mới</button></Link>
                </div>
            </div>
            {listAddress &&
            listAddress.map((item,index) => (
                <div className={'col-sm-12 col-md-12 col-lg-12 borderForm listForm'} key={index}>
                <div className={"topList"}> <strong><h5 key={item.id} ><>Họ và tên: </>{item.fullName}</h5></strong>
                  <span className={"deleteAddress"} onClick={()=>{
                      deleteAddress(item)
                  }}>Xóa</span></div>
                    <div>
                        <span><i className="fa-solid fa-location-dot"></i></span><span>Địa chỉ</span>
                        <p>{item.address}</p>
                    </div>
                    <div>
                        <span><i className="fa-solid fa-phone"></i></span><span>Số điện thoại</span>
                        <p>{item.phone}</p>
                    </div>
                    <div>
                        <span><i className="fa-regular fa-envelope"></i></span><span>Địa chỉ email</span>
                        <p>{item.email}</p>
                    </div>
                <div>
                    <Link to={`/edit/${item.id}`}>Chỉnh sửa</Link>
                </div>
                </div>


            ))}
        </div>
    );
}

export default ListAddress;