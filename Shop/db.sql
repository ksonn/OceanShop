USE [DBSap]
GO
/****** Object:  Table [dbo].[ADMIN]    Script Date: 07/11/2024 12:05:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ADMIN](
	[idUser] [nchar](10) NULL,
	[Email] [nchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[Role] [nvarchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 07/11/2024 12:05:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[idSanPham] [nchar](10) NULL,
	[idDonHang] [nchar](10) NOT NULL,
	[idUser] [nchar](10) NULL,
	[TenKH] [nvarchar](50) NULL,
	[SDT] [int] NULL,
	[TongSoLuong] [int] NULL,
	[NgayBan] [date] NULL,
	[TongThanhTien] [int] NULL,
	[isPay] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 07/11/2024 12:05:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idHoaDon] [nchar](10) NOT NULL,
	[idDonHang] [nchar](10) NULL,
	[idSanPham] [nchar](10) NULL,
	[TenSanPham] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[GiaTien] [int] NULL,
	[ThanhTien] [int] NULL,
	[isPay] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 07/11/2024 12:05:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[idUser] [nchar](10) NOT NULL,
	[TenUser] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[Email] [nchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[SDT] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanLoai]    Script Date: 07/11/2024 12:05:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanLoai](
	[idPhanLoai] [nchar](10) NOT NULL,
	[ThuongHieu] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhanLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 07/11/2024 12:05:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[idSanPham] [nchar](10) NOT NULL,
	[TenSanPham] [nvarchar](50) NULL,
	[TongSoLuong] [int] NULL,
	[GiaBanDau] [int] NULL,
	[GiaSanPham] [int] NULL,
	[AnhMinhHoa] [text] NULL,
	[AnhMoTa] [text] NULL,
	[MoTaSanPham] [nvarchar](255) NULL,
	[ThuongHieu] [nvarchar](115) NULL,
	[MauSac] [nvarchar](50) NULL,
	[idPhanLoai] [nchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[ADMIN] ([idUser], [Email], [MatKhau], [Role]) VALUES (N'1         ', N'vana@gmail.com                                    ', N'prj123456', N'Admin')
INSERT [dbo].[ADMIN] ([idUser], [Email], [MatKhau], [Role]) VALUES (N'2         ', N'thib@gmail.com                                    ', N'prj12345', N'Employee')
INSERT [dbo].[ADMIN] ([idUser], [Email], [MatKhau], [Role]) VALUES (N'14        ', N'testadd@gmail.com                                 ', N'prj1234', N'Admin')
INSERT [dbo].[ADMIN] ([idUser], [Email], [MatKhau], [Role]) VALUES (N'15        ', N'Testadd@gmail.com                                 ', N'prj12345', N'Employee')
GO
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'1         ', N'1         ', N'2         ', N'Nguyen Thi B', 382761325, 2, CAST(N'2024-07-09' AS Date), 14000000, 0)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'5         ', N'10        ', N'4         ', N'Nguyen Thi D', 983744532, 2, CAST(N'2024-07-10' AS Date), 12000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'9         ', N'11        ', N'4         ', N'Nguyen Thi D', 983744532, 1, CAST(N'2024-07-10' AS Date), 5600000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'2         ', N'12        ', N'4         ', N'Nguyen Thi D', 983744532, 1, CAST(N'2024-07-10' AS Date), 4000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'5         ', N'13        ', N'5         ', N'Nguyen Van e', 929834754, 2, CAST(N'2024-07-10' AS Date), 12000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'1         ', N'14        ', N'11        ', N'Dinh Cong Minh', 929834717, 3, CAST(N'2024-07-10' AS Date), 21000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'1         ', N'15        ', N'12        ', N'Dinh Cong Manh', 929834983, 2, CAST(N'2024-07-10' AS Date), 14000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'9         ', N'16        ', N'12        ', N'Dinh Cong Manh', 929834983, 2, CAST(N'2024-07-10' AS Date), 11200000, 0)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'1         ', N'19        ', N'4         ', N'Nguyen Thi D', 983744532, 2, CAST(N'2024-07-10' AS Date), 14000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'2         ', N'2         ', N'11        ', N'Dinh Cong Minh', 929834717, 3, CAST(N'2024-07-09' AS Date), 12000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'9         ', N'20        ', N'4         ', N'Nguyen Thi D', 983744532, 1, CAST(N'2024-07-10' AS Date), 5600000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'4         ', N'21        ', N'6         ', N'Nguyen Hoang Nam', 929834751, 2, CAST(N'2024-07-10' AS Date), 10000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'2         ', N'22        ', N'6         ', N'Nguyen Hoang Nam', 929834751, 3, CAST(N'2024-07-10' AS Date), 12000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'9         ', N'23        ', N'6         ', N'Nguyen Hoang Nam', 929834751, 3, CAST(N'2024-07-10' AS Date), 16800000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'13        ', N'24        ', N'6         ', N'Nguyen Hoang Nam', 929834751, 3, CAST(N'2024-07-10' AS Date), 9000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'5         ', N'3         ', N'11        ', N'Dinh Cong Minh', 929834717, 6, CAST(N'2024-07-10' AS Date), 36000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'9         ', N'4         ', N'11        ', N'Dinh Cong Minh', 929834717, 4, CAST(N'2024-07-09' AS Date), 22400000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'1         ', N'5         ', N'12        ', N'Dinh Cong Manh', 929834983, 5, CAST(N'2024-07-10' AS Date), 35000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'5         ', N'6         ', N'12        ', N'Dinh Cong Manh', 929834983, 6, CAST(N'2024-07-10' AS Date), 36000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'8         ', N'7         ', N'11        ', N'Dinh Cong Minh', 929834717, 2, CAST(N'2024-07-10' AS Date), 8000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'1         ', N'8         ', N'4         ', N'Nguyen Thi D', 983744532, 3, CAST(N'2024-07-10' AS Date), 21000000, 1)
INSERT [dbo].[DonHang] ([idSanPham], [idDonHang], [idUser], [TenKH], [SDT], [TongSoLuong], [NgayBan], [TongThanhTien], [isPay]) VALUES (N'2         ', N'9         ', N'4         ', N'Nguyen Thi D', 983744532, 1, CAST(N'2024-07-10' AS Date), 4000000, 1)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'1         ', N'2         ', N'2         ', N'Toshiba', 3, 4000000, 12000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'10        ', N'3         ', N'5         ', N'Funiki Eco', 6, 6000000, 36000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'11        ', N'4         ', N'9         ', N'Samsung Smart G2', 4, 5600000, 22400000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'12        ', N'7         ', N'8         ', N'Toshiba Avepoint', 2, 4000000, 8000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'13        ', N'5         ', N'1         ', N'Samsung Oled', 5, 7000000, 35000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'14        ', N'6         ', N'5         ', N'Funiki Eco', 2, 6000000, 12000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'16        ', N'19        ', N'1         ', N'Samsung Oled', 2, 7000000, 14000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'17        ', N'21        ', N'4         ', N'Funiki EBP', 2, 5000000, 10000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'18        ', N'22        ', N'2         ', N'Toshiba', 3, 4000000, 12000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'19        ', N'24        ', N'13        ', N'Test 12', 3, 3000000, 9000000, 1)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'2         ', N'3         ', N'5         ', N'Funiki Eco', 6, 6000000, 36000000, 0)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'3         ', N'4         ', N'9         ', N'Samsung Smart G2', 4, 5600000, 22400000, 0)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'4         ', N'7         ', N'8         ', N'Toshiba Avepoint', 2, 4000000, 8000000, 0)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'5         ', N'2         ', N'2         ', N'Toshiba', 3, 4000000, 12000000, 0)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'6         ', N'3         ', N'5         ', N'Funiki Eco', 6, 6000000, 36000000, 0)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'7         ', N'4         ', N'9         ', N'Samsung Smart G2', 4, 5600000, 22400000, 0)
INSERT [dbo].[HoaDon] ([idHoaDon], [idDonHang], [idSanPham], [TenSanPham], [SoLuong], [GiaTien], [ThanhTien], [isPay]) VALUES (N'9         ', N'2         ', N'2         ', N'Toshiba', 3, 4000000, 12000000, 0)
GO
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'1         ', N'Nguyen Van A', N'Nam', N'vana@gmail.com                                    ', N'prj123456', 382761327)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'10        ', N'Tran Hoa My', N'Nam', N'trmy@gmail.com                                    ', N'prj12345', 929834711)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'11        ', N'Dinh Cong Minh', N'Nam', N'dinhminh@gmail.com                                ', N'prj12345', 929834717)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'12        ', N'Dinh Cong Manh', N'Nam', N'dinhmanh@gmail.com                                ', N'prj12345', 929834983)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'13        ', N'Helio', N'Nu', N'helio@gmail.com                                   ', N'prj1234', 93287483)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'14        ', N'Test Add Admin', N'Nam', N'testadd@gmail.com                                 ', N'prj1234', 937826475)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'15        ', N'Test Add Employee', N'Nam', N'Testadd@gmail.com                                 ', N'prj12345', 983473243)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'2         ', N'Nguyen Thi BIch', N'Nu', N'thib@gmail.com                                    ', N'prj12345', 382761325)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'3         ', N'Nguyen Nam Dao', N'Nam', N'nam1@gmail.com                                    ', N'prj12345', 382761326)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'4         ', N'Nguyen Thi D', N'Nu', N'vand@gmail.com                                    ', N'prj12345', 983744532)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'5         ', N'Nguyen Van e', N'Nam', N'vane@gmail.com                                    ', N'prj12345', 929834754)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'6         ', N'Nguyen Hoang Nam', N'Nam', N'hnam@gmail.com                                    ', N'prj12345', 929834751)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'7         ', N'Dao Thi Huong', N'Nu', N'dhuong@gmail.com                                  ', N'prj12345', 929834752)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'8         ', N'Dao Thi Ly', N'Nu', N'dly@gmail.com                                     ', N'prj12345', 929834755)
INSERT [dbo].[NguoiDung] ([idUser], [TenUser], [GioiTinh], [Email], [MatKhau], [SDT]) VALUES (N'9         ', N'Tran Minh Nguyet', N'Nu', N'trnguyt@gmail.com                                 ', N'prj12345', 929834721)
GO
INSERT [dbo].[PhanLoai] ([idPhanLoai], [ThuongHieu]) VALUES (N'1         ', N'Tivi')
INSERT [dbo].[PhanLoai] ([idPhanLoai], [ThuongHieu]) VALUES (N'2         ', N'Tủ Lạnh')
INSERT [dbo].[PhanLoai] ([idPhanLoai], [ThuongHieu]) VALUES (N'3         ', N'Loa')
INSERT [dbo].[PhanLoai] ([idPhanLoai], [ThuongHieu]) VALUES (N'4         ', N'Máy Giặt')
INSERT [dbo].[PhanLoai] ([idPhanLoai], [ThuongHieu]) VALUES (N'5         ', N'Nồi Cơm Điện')
INSERT [dbo].[PhanLoai] ([idPhanLoai], [ThuongHieu]) VALUES (N'6         ', N'Máy Lạnh')
GO
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'1         ', N'Samsung Oled', 10, 3000000, 7000000, null, null, N'Tivi Thông Minh Samsung', N'Samsung', N'Đen', N'1         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'10        ', N'Baseus G112', 26, 1100000, 2300000, NULL, NULL, N'Loa Baseus siêu base', N'Baseus', N'Đen', N'3         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'12        ', N'Test', 300, 2000000, 3000000, null, null, N'Test', N'Test', N'Đen', N'3         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'13        ', N'Test 12', 122, 2000000, 3000000, N'lib/img/', N'lib/img/', N'123412', N'Test 12', N'Test 12', N'5         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'14        ', N'Test Img2', 3000, 100000, 150000, null, null, N'Test Img2', N'Bet', N'Red', N'3         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'2         ', N'Toshiba', 5, 2000000, 4000000, NULL, NULL, N'Tivi Oled', N'Toshiba', N'Đen', N'1         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'3         ', N'MashMallow', 8, 1000000, 3000000, NULL, NULL, N'Loa MashMallow', N'MashMallow', N'Xám Ghi', N'3         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'4         ', N'Funiki EBP', 19, 2000000, 5000000, NULL, NULL, N'Máy Giặt Cửa Trên Funiki', N'Funiki', N'Đen', N'4         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'5         ', N'Funiki Eco', 556, 2000000, 6000000, null, null, N'Tủ Lạnh Funiki Tiết Kiệm Điện', N'Funiki', N'Xám', N'2         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'6         ', N'Funiki Hygen', 15, 3000000, 5500000, NULL, NULL, N'Điều Hoà Không Khí Nano', N'Funiki', N'Trắng Sữa', N'6         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'7         ', N'Toshiba Aventado', 8, 2500000, 4500000, NULL, NULL, N'Điều Hoà Không Khí Nano', N'Toshiba', N'Trắng', N'6         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'8         ', N'Toshiba Avepoint', 11, 3000000, 4000000, NULL, NULL, N'Điều Hoà Không Khí Nano', N'Toshiba', N'Trắng', N'6         ')
INSERT [dbo].[SanPham] ([idSanPham], [TenSanPham], [TongSoLuong], [GiaBanDau], [GiaSanPham], [AnhMinhHoa], [AnhMoTa], [MoTaSanPham], [ThuongHieu], [MauSac], [idPhanLoai]) VALUES (N'9         ', N'Samsung Smart G2', 14, 4400000, 5600000, NULL, NULL, N'Tủ Lạnh Samsung Tiết Kiệm Điện Công Nghệ Nano', N'Samsung', N'Đen Nhám', N'2         ')
GO
ALTER TABLE [dbo].[ADMIN]  WITH CHECK ADD FOREIGN KEY([idUser])
REFERENCES [dbo].[NguoiDung] ([idUser])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([idUser])
REFERENCES [dbo].[NguoiDung] ([idUser])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__idDonHan__2F10007B] FOREIGN KEY([idDonHang])
REFERENCES [dbo].[DonHang] ([idDonHang])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__idDonHan__2F10007B]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([idPhanLoai])
REFERENCES [dbo].[PhanLoai] ([idPhanLoai])
GO
